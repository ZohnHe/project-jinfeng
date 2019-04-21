package com.jfone.mall.base.controller;

import com.github.pagehelper.PageInfo;
import com.jfone.mall.base.common.BaseResponse;

import com.jfone.mall.base.entity.work.JfoneCoustomer;
import com.jfone.mall.base.entity.work.dto.CoustomerAddEntity;
import com.jfone.mall.base.entity.work.dto.CoustomerDeleteEntity;
import com.jfone.mall.base.entity.work.dto.CoustomerModifyEntity;
import com.jfone.mall.base.entity.work.dto.CoustomerQueryEntity;
import com.jfone.mall.base.entity.work.resp.CoustomerAddResp;
import com.jfone.mall.base.entity.work.resp.CoustomerDeleteResp;
import com.jfone.mall.base.entity.work.resp.CoustomerListResp;
import com.jfone.mall.base.entity.work.resp.CoustomerModifyResp;
import com.jfone.mall.base.service.Coustomerbiz;
import com.jfone.mall.base.utils.RequestAssets;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller("coustomerController")
@Api(tags="用户管理模块")  //swagger分类标题注解
@RequestMapping(value = "/coustomer",method = RequestMethod.POST)
public class CoustomerController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Autowired
    @Qualifier(value = "coustomerbiz")
    private Coustomerbiz coustomerbiz;


    @ApiOperation(value = "获取未冻结用户列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<CoustomerListResp<JfoneCoustomer>> getCoustomerList(@Valid @RequestBody CoustomerQueryEntity
                                                                                        coustomerQueryEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        //PbGoodsInfo poGoodsInfo = new PbGoodsInfo();
        //利用插件获取用户信息
        PageInfo<JfoneCoustomer> list = coustomerbiz.getCoustomerList(coustomerQueryEntity);
        /* 属性拷贝,可以使用Bean转换工具DozerBeanMapper */
        //List<VoGoodsInfo> data = new ArrayList<VoGoodsInfo>();
        /*if(list.getList() != null){
            for(JfoneCoustomer jfoneCoustomer:list.getList()){
                VoGoodsInfo bean = new VoGoodsInfo();
                try {
                    BeanUtils.copyProperties(jfoneCoustomer,bean);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                data.add(bean);
            }
        }*/

        //将list<VoGoodsInfo>数据存入GoodsListResp的data中
        CoustomerListResp<JfoneCoustomer> responseEntity = new CoustomerListResp(list.getList());

        responseEntity.setPageNum(coustomerQueryEntity.getPageNum());
        responseEntity.setPageSize(coustomerQueryEntity.getPageSize());
        responseEntity.setTotalRecord(list.getTotal());  //返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647
        long totalPage = (responseEntity.getTotalRecord()+coustomerQueryEntity.getPageSize()-1)/coustomerQueryEntity.getPageSize(); //(总记录数+分页数-1)/分页数
        responseEntity.setTotalPage(totalPage);

        return new BaseResponse(responseEntity);
    }

    @ApiOperation(value = "获取冻结用户列表数据", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/listF",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<CoustomerListResp<JfoneCoustomer>> getCoustomerFList(@Valid @RequestBody CoustomerQueryEntity
                                                                                         coustomerQueryEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        //利用插件获取用户信息
        PageInfo<JfoneCoustomer> list = coustomerbiz.getCoustomerFList(coustomerQueryEntity);

        //将list<VoGoodsInfo>数据存入GoodsListResp的data中
        CoustomerListResp<JfoneCoustomer> responseEntity = new CoustomerListResp(list.getList());

        responseEntity.setPageNum(coustomerQueryEntity.getPageNum());
        responseEntity.setPageSize(coustomerQueryEntity.getPageSize());
        responseEntity.setTotalRecord(list.getTotal());  //返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647
        long totalPage = (responseEntity.getTotalRecord()+coustomerQueryEntity.getPageSize()-1)/coustomerQueryEntity.getPageSize(); //(总记录数+分页数-1)/分页数
        responseEntity.setTotalPage(totalPage);

        return new BaseResponse(responseEntity);
    }


/*    @ApiOperation(value = "删除指定用户", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<CoustomerDeleteResp> CoustomerDelete(@Valid @RequestBody CoustomerDeleteEntity coustomerDeleteEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);
        CoustomerDeleteResp coustomerDeleteResp = new CoustomerDeleteResp();
        coustomerDeleteResp.setResult(coustomerbiz.CoustomerDelete(coustomerDeleteEntity.getCoustomerIds()));

        return new BaseResponse(coustomerDeleteResp);
    }*/

    @ApiOperation(value = "删除指定用户", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<CoustomerDeleteResp> CoustomerDelete(HttpServletRequest request, @Valid @RequestBody CoustomerDeleteEntity coustomerDeleteEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);
        CoustomerDeleteResp coustomerDeleteResp = new CoustomerDeleteResp();
        coustomerDeleteResp.setResult(coustomerbiz.CoustomerDelete(coustomerDeleteEntity.getCoustomerIds()));

        return new BaseResponse(coustomerDeleteResp);
    }
    @ApiOperation(value = "添加用户", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<CoustomerAddResp> CoustomerAdd(HttpServletRequest request, @Valid @RequestBody CoustomerAddEntity
            coustomerAddEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        CoustomerAddResp coustomerAddResp = new CoustomerAddResp();
        coustomerAddResp.setResult(coustomerbiz.CoustomerAdd(coustomerAddEntity));
        System.out.println("添加成功");
        return new BaseResponse(coustomerAddResp);
    }
    @ApiOperation(value = "修改用户信息", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<CoustomerModifyResp> CoustomerModify(HttpServletRequest request, @Valid @RequestBody
            CoustomerModifyEntity coustomerModifyEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        CoustomerModifyResp coustomerModifyResp = new CoustomerModifyResp();
        coustomerModifyResp.setResult(coustomerbiz.CoustomerModify(coustomerModifyEntity));

        return new BaseResponse(coustomerModifyResp);
    }


/*    @ApiOperation(value = "修改用户状态信息", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/modifyF",method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<GoodsModifyResp> goodsFModify(HttpServletRequest request, @Valid @RequestBody
            GoodsModifyEntity goodsModifyEntity, BindingResult errors){
        //请求参数异常处理，加错误提示
        RequestAssets.assetsError(errors);

        GoodsModifyResp goodsModifyResp = new GoodsModifyResp();
        goodsModifyResp.setResult(coustomerbiz.CoustomerFModify(goodsModifyEntity));

        return new BaseResponse(goodsModifyResp);
    }*/



}
