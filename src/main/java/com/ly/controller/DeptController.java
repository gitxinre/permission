package com.ly.controller;

import com.ly.common.ReturnResult;
import com.ly.dao.DeptDao;
import com.ly.entity.dto.DeptDTO;
import com.ly.entity.po.DeptPO;
import com.ly.entity.pojo.TreeNode;
import com.ly.service.DeptService;
import com.ly.util.TreeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xinre
 */
@RestController
@RequestMapping("/demo/dept")
@Slf4j
public class DeptController {

    @Autowired(required = false)
    private DeptService deptService;

    @RequestMapping("/saveDept.json")
    public ReturnResult saveDept(DeptDTO deptDTO) {
        deptService.saveDept(deptDTO);
        return ReturnResult.success();
    }

    @RequestMapping("/listDeptTree.json")
    public ReturnResult listDeptTree() {
        List<TreeNode> treeNodes = deptService.listDeptTree();
        return ReturnResult.success(treeNodes);
    }

    @RequestMapping("/listDept.json")
    public ReturnResult listDept() {
        List<DeptPO> treeNodes = deptService.listDept();
        return ReturnResult.success(treeNodes);
    }

    @RequestMapping("/updateDept.json")
    public ReturnResult updateDept(DeptDTO deptDTO) {
        deptService.updatDeptById(deptDTO);
        return ReturnResult.success();
    }
}
