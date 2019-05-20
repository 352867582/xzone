package com.xzone.xinterface.app.service;

import com.xzone.xinterface.app.model.HotSearch;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 热搜信息表 服务类
 * </p>
 *
 * @author kongkong
 * @since 2019-05-20
 */
public interface HotSearchService extends IService<HotSearch> {

   public void addHotSearch(HotSearch hotSearch);

}
