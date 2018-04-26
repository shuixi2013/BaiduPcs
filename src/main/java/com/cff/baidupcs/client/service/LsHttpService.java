package com.cff.baidupcs.client.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cff.baidupcs.common.Constant;
import com.cff.baidupcs.model.dto.BaiduDto;
import com.cff.baidupcs.model.dto.PcsFileDto;
import com.cff.baidupcs.model.store.BaiduClientStore;
import com.cff.baidupcs.util.OkHttpUtil;
import com.cff.baidupcs.util.StringUtil;

public class LsHttpService {
	PcsClientService pcsClientService;

	public LsHttpService(PcsClientService pcsClientService) {
		this.pcsClientService = pcsClientService;
	}
	
	public LsHttpService() {
		this.pcsClientService = new PcsClientService();
	}

	public void runLs(String path) {
		try {
			List<PcsFileDto> pcsFileDtos = getPcsPath(path);
			for(PcsFileDto pcsFileDto : pcsFileDtos){
				System.out.println(pcsFileDto.getPath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<PcsFileDto> getPcsPath(String path) throws IOException {
		BaiduDto baiduDto = BaiduClientStore.currentActiveBaiduDto;
		String workDir = StringUtil.cleanPath(baiduDto.getWorkdir());
		path = StringUtil.cleanPath(path);
		if (!path.startsWith("/")) {
			path = StringUtil.cleanPath(workDir + "/" + path);
		}
		List<PcsFileDto> pcsFileDtos = new ArrayList<PcsFileDto>();
		String res = pcsClientService.prepareFilesDirectoriesList(path);
		JSONObject json = JSONObject.parseObject(res);
		if(json == null)return null;
		JSONArray ja = json.getJSONArray("list");
		for(Object tmp : ja){
			JSONObject jobj = (JSONObject) tmp;
			PcsFileDto pcsFileDto = (PcsFileDto) JSONObject.toJavaObject(jobj, PcsFileDto.class);
			pcsFileDtos.add(pcsFileDto);
		}
		return pcsFileDtos;
	}

	
}
