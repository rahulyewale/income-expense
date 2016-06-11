package com.personal.utility.service.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.business.dto.ChargeDetails;
import com.logistics.business.dto.InvoiceDetails;
import com.personal.common.CommonConstants;
import com.personal.common.ServiceRequest;
import com.personal.common.json.util.JsonUtil;
import com.personal.dao.OrderDetailDAO;
import com.personal.dto.CSvFileVO;
import com.personal.dto.IncomeExpenseSummaryRequest;
import com.personal.dto.LogisticsResponse;
import com.personal.entity.OrderDetail;
import com.personal.utility.service.util.PGCopy;

/**
 */
@Component
public class LogisticsService
{
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;

	

	public LogisticsResponse generateInvoice(ServiceRequest serviceRequest) throws Exception
	{
		List<OrderDetail> orderDetailsList = orderDetailDAO.getOrderDetails();
		
		List<InvoiceDetails> invoiceDetailsList = new ArrayList<InvoiceDetails>();
		
		for (OrderDetail orderDetail : orderDetailsList)
		{

			InvoiceDetails invoiceDetails = createInvoice(orderDetail);

			invoiceDetailsList.add(invoiceDetails);
		}
		
		
		String pathForSaving = "E:\\Rahul\\sunilj\\report\\master-actual.pdf";
		String pathForSavingxl = "E:\\Rahul\\sunilj\\report\\master.xlsx";
		String pathForSavingdocx = "E:\\Rahul\\sunilj\\report\\master.docx";
		String pathForMaster = "E:\\Rahul\\sunilj\\report\\jrxml\\master.jrxml";
		String subReportFileName = "E:\\Rahul\\sunilj\\report\\jrxml\\sub.jrxml";
		
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(invoiceDetailsList);
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		File masterReportPattern = new File(pathForMaster);
		JasperDesign jasperDesign = JRXmlLoader.load(masterReportPattern);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		
		File subRepPattern = new File(subReportFileName);
		JasperDesign subRepPatternDesign = JRXmlLoader.load(subRepPattern);
		JasperReport jasperSubReport = JasperCompileManager.compileReport(subRepPatternDesign);
		
		parameters.put("subreportParameter", jasperSubReport);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, pathForSaving);
		
		/*//Export to excel
		JRXlsxExporter exporter = new JRXlsxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		File outputFile = new File(pathForSavingxl);
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFile));
		SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration(); 
		configuration.setDetectCellType(true);//Set configuration as you like it!!
		configuration.setCollapseRowSpan(false);
		exporter.setConfiguration(configuration);
		exporter.exportReport();
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}
	
	
	


private InvoiceDetails createInvoice(OrderDetail orderDetail)
	{
		InvoiceDetails invoiceDetails = new InvoiceDetails();

		invoiceDetails.setAwbNo(orderDetail.getDocumentNo());

		invoiceDetails.setDeliveryDate(orderDetail.getBookingDate());
		invoiceDetails.setPieces(String.valueOf(orderDetail.getPackageCount()));
		invoiceDetails.setRecepient(orderDetail.getAddress());
		invoiceDetails.setRefNo(orderDetail.getInvoiceNo());

		String shipper = "Rieter India Pvt. Ltd.Shindewadi,Shirwal.";

		invoiceDetails.setShipper(shipper);
		// TODO: Need to have strategy to define delivery date.
		invoiceDetails.setShippingDate(orderDetail.getBookingDate());
		invoiceDetails.setWeight(String.valueOf(orderDetail.getFedexWeight()));

		// TODO : Remove this..not required.
		ChargeDetails chargeDetails = new ChargeDetails();
		invoiceDetails.getServiceChargeList().add(chargeDetails);

		invoiceDetails.setAwbCharges(123);
		invoiceDetails.setFovCharges(345);
		invoiceDetails.setFrightCharges(12345);
		invoiceDetails.setFuelSurcharges(5555);
		invoiceDetails.setOdaCharges(345);
		invoiceDetails.setServiceTax(543);
		invoiceDetails.setTotalAmount(112345);

		return invoiceDetails;
	}





@Transactional
	public LogisticsResponse loadCsv(ServiceRequest serviceRequest)
	{
	
	CSvFileVO cSvFileVO = null;
	try
	{
		String insertValuesString = JsonUtil.convertObjectToJson(serviceRequest.get("CSV_FILE"));
		cSvFileVO = (CSvFileVO) JsonUtil.convertJsonToObject(insertValuesString, CSvFileVO.class);
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	
	
		PGCopy pgCopy = new PGCopy();
		pgCopy.loadCSV(cSvFileVO.getInsert_values());
		//orderDetailDAO.loadCsv("");
		return null;
	}

}
