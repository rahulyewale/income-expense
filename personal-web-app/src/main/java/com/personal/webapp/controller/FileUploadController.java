package com.personal.webapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.personal.common.json.util.JsonUtil;
import com.personal.dto.ItemInfoDTO;
import com.personal.webapp.client.RestServiceClient;

@Controller
public class FileUploadController
{

	@Autowired
	private RestServiceClient restServiceClient;

	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public String displayForm()
	{
		return "file_upload_form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(MultipartHttpServletRequest request, HttpServletResponse response)
	{ // 0. notice, we have used MultipartHttpServletRequest

		// 1. get the files from the request object
		Iterator<String> itr = request.getFileNames();

		String fileName = request.getParameter("fileName");

		MultipartFile mpf = request.getFile(itr.next());
		System.out.println(mpf.getOriginalFilename() + " uploaded!");
		ModelAndView modelAndView = new ModelAndView("file_upload_success");

		try
		{
			// just temporary save file info into ufile
			/*
			 * ufile.length = mpf.getBytes().length; ufile.bytes= mpf.getBytes();
			 * ufile.type = mpf.getContentType(); ufile.name =
			 * mpf.getOriginalFilename();
			 */
			ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
			itemInfoDTO.setItemName(fileName);
			String strItemInfoDTO = JsonUtil.convertObjectToJson(itemInfoDTO);
			restServiceClient.invokeRestService(strItemInfoDTO, "http://localhost:8765/SpringMVC/rest/kfc/brands/abc", "", "");
			List<String> strings = new ArrayList<String>();
			strings.add(mpf.getOriginalFilename());
			modelAndView.addObject("files", strings);

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
}