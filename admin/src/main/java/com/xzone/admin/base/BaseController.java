package com.xzone.admin.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzone.utils.ContextHolderUtil;
import com.xzone.xinterface.base.BaseModel;
import com.xzone.xinterface.common.constant.CommonConstant;
import com.xzone.xinterface.common.vo.AjaxJson;
import com.xzone.xinterface.sys.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
public class BaseController<T extends BaseModel> {

    /**
     * 分页查询 返回的数据包含分页信息
     */
    @PostMapping(value = "/selectPageRecords")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public AjaxJson selectPageRecords(T t) {
        IPage<T> selectPage = t.selectPage(new QueryWrapper(t));
        return new AjaxJson().setData(selectPage);
    }

    /**
     * 分页查询 返回的数据只有结果 不包含分页参数如共多少等等
     */
    @PostMapping(value = "/selectPage")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public AjaxJson selectPage(T t) {
        IPage<T> selectPage = t.selectPage(new QueryWrapper(t));
        return new AjaxJson().setData(selectPage.getRecords());
    }

    /**
     * 查询列表  不分页
     */
    @PostMapping(value = "/selectList")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public AjaxJson selectList(T t) {
        List<T> list = t.selectList(new QueryWrapper(t));
        return new AjaxJson().setData(list);
    }

    /**
     * 更新
     */
    @PostMapping(value = "/updateById")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public AjaxJson updateById(T t) {
        t.updateById();
        return new AjaxJson();
    }

    /**
     * 创建
     */
    @PostMapping(value = "/create")
    @ResponseBody
    public AjaxJson create(T t) {
        t.insert();
        return new AjaxJson();
    }

    @PostMapping(value = "/deleteById")
    @ResponseBody
    public AjaxJson deleteById(T t) {
        t.deleteById();
        return new AjaxJson();
    }

    @PostMapping(value = "/selectById")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public AjaxJson selectById(T t) {
        T select = (T) t.selectById();
        return new AjaxJson().setData(select);
    }

    public String getSysUserId() {
        Object userIdObj = ContextHolderUtil.getRequest().getAttribute(CommonConstant.SYS_REQUEST_USER_ID);
        return String.valueOf(userIdObj);
    }

    public SysUser getSysUser() {
        Object userIdObj = ContextHolderUtil.getRequest().getAttribute(CommonConstant.SYS_REQUEST_USER_ID);
        return new SysUser().selectById(String.valueOf(userIdObj));
    }
}
