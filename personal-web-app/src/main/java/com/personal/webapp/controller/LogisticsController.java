package com.personal.webapp.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.personal.common.CommonConstants;
import com.personal.common.ServiceRequest;
import com.personal.common.ServiceResponse;
import com.personal.common.context.ContextInfo;
import com.personal.dto.CSvFileVO;
import com.personal.rest.client.RestServiceInvoker;

@Controller(value = CommonConstants.RequestMapping.LOGISTICS)
public class LogisticsController
{


	@Autowired	
	RestServiceInvoker restServiceInvoker;
	
	@ResponseBody
	@RequestMapping(headers ="content-type=multipart/*",value = CommonConstants.RequestMapping.GENERATE_INVOICE, method = RequestMethod.POST)
	public ServiceResponse generateInvoice(HttpServletRequest httpServletRequest)
	{
		
		ContextInfo contextInfo = new ContextInfo("System");

		ServiceRequest serviceRequest = new ServiceRequest(contextInfo);

		ServiceResponse serviceResponse = restServiceInvoker.invokeRestService(serviceRequest, CommonConstants.RequestMapping.GENERATE_INVOICE);
		
		return null;
		
	}
	
	@RequestMapping(value = CommonConstants.RequestMapping.GET_LOGISTICS, method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getLogistics(HttpServletRequest httpServletRequest)
	{
		
		return  new ModelAndView("logistics");
		
	}
	
	@ResponseBody
	@RequestMapping(value = CommonConstants.RequestMapping.LOAD_CSV, method = { RequestMethod.GET, RequestMethod.POST})
	public ServiceResponse loadCsv(MultipartHttpServletRequest request)
	{
		ContextInfo contextInfo = new ContextInfo("System");

		ServiceRequest serviceRequest = new ServiceRequest(contextInfo);
		
		
		MultipartFile multiPartFile = null;
		Iterator<String> fileList = request.getFileNames();
		if (fileList.hasNext())
		{
			multiPartFile = request.getFile(fileList.next());
		}
		
		byte[] insert_values = null;
		if (null != multiPartFile)
		{
			try
			{
				insert_values= multiPartFile.getBytes();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		CSvFileVO cSvFileVO = new CSvFileVO(); 
		
		cSvFileVO.setInsert_values(insert_values);
		
		serviceRequest.add("CSV_FILE", cSvFileVO);
		

		ServiceResponse serviceResponse = restServiceInvoker.invokeRestService(serviceRequest, CommonConstants.RequestMapping.LOAD_CSV);
		return null; 
	}
	
	public void setCsvDetails(MultipartHttpServletRequest request) throws IOException
	{
		MultipartFile mpf = getPhotoFile(request);
		if (null != mpf)
		{
			//photoVO.setPhotoContent(mpf.getBytes());
		//	photoVO.setPhotoName(mpf.getOriginalFilename());
			//photoVO.setMpfSize(mpf.getSize());
		}
	}
	
	public MultipartFile getPhotoFile(MultipartHttpServletRequest request)
	{
		MultipartFile multiPartFile = null;
		Iterator<String> fileList = request.getFileNames();
		if (fileList.hasNext())
		{
			multiPartFile = request.getFile(fileList.next());
		}
		return multiPartFile;
	}

}
