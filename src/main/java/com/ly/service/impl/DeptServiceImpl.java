package com.ly.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ly.dao.DeptDao;
import com.ly.entity.dto.DeptDTO;
import com.ly.entity.po.DeptPO;
import com.ly.entity.pojo.TreeNode;
import com.ly.service.DeptService;
import com.ly.util.IdGenerator;
import com.ly.util.PinYinUtils;
import com.ly.util.CollectionUtil;
import com.ly.util.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xinre
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired(required = false)
    private DeptDao deptDao;

    @Override
    public void saveDept(DeptDTO deptDTO) {
        if (StringUtils.isBlank(deptDTO.getPId())) {
            deptDTO.setPId(TreeUtils.ROOT_PARENT_ID);
        }
        DeptPO deptPO = DeptPO.builder()
                .pId(deptDTO.getPId())
                .orderId(deptDTO.getOrderId())
                .remark(deptDTO.getRemark())
                .level(0) //todo:
                .operator("operator") //todo:
                .operateIp("127.0.0.1") //todo:
                .operateTime(new Date())
                .build();
        deptPO.setId(IdGenerator.guid());
        deptPO.setName(deptDTO.getName());
        deptPO.setNameHeadChar(PinYinUtils.headChar(deptDTO.getName()));
        deptDao.saveDept(deptPO);
    }

    @Override
    public List<TreeNode> listDeptTree() {
        return TreeUtils.build(listDept2ListTreeNode(listDept()));
    }

    @Override
    public List<DeptPO> listDept() {
        List<DeptPO> deptPOList = deptDao.listDept();
        CollectionUtil.baseEntityListSort(deptPOList);
        return deptPOList;
    }

    public List<DeptPO> listDept1() {
        Page page = PageHelper.startPage(2, 5);
        deptDao.listDept();
        return page.getResult();
    }

    public Page listDeptPage(int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum, pageSize);
        deptDao.listDept();
        return page;
    }

    public Page listDeptPage(int pageNum, int pageSize, boolean isCount) {
        Page page = PageHelper.startPage(pageNum, pageSize, isCount);
        deptDao.listDept();
        return page;
    }

    @Override
    public void updatDeptById(DeptDTO deptDTO) {
        DeptPO deptPO = DeptPO.builder()
                .operateTime(new Date())
                .remark(deptDTO.getRemark())
                .pId(deptDTO.getPId())
                .orderId(deptDTO.getOrderId())
                .operateIp("127.0.0.1")
                .operator("operator update")
                .build();
        deptPO.setId(deptDTO.getId());
        deptPO.setName(deptDTO.getName());
        deptPO.setNameHeadChar(PinYinUtils.headChar(deptDTO.getName()));
        deptDao.updatDeptById(deptPO);
    }

    private List<TreeNode> listDept2ListTreeNode(List<DeptPO> deptPOList) {
        List<TreeNode> r = new ArrayList<TreeNode>();
        for (DeptPO dept : deptPOList) {
            r.add(TreeNode.builder()
                    .id(dept.getId())
                    .text(dept.getName())
                    .parentId(dept.getPId())
                    .build());
        }
        return r;
    }


}
