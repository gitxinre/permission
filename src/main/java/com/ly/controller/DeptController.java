package com.ly.controller;

import com.ly.common.Result;
import com.ly.entity.dto.DeptDTO;
import com.ly.entity.po.DeptPO;
import com.ly.entity.pojo.TreeNode;
import com.ly.service.DeptService;
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
    public Result saveDept(DeptDTO deptDTO) {
        deptService.saveDept(deptDTO);
        return Result.success();
    }

    @RequestMapping("/listDeptTree.json")
    public Result listDeptTree() {
        List<TreeNode> treeNodes = deptService.listDeptTree();
        return Result.success(treeNodes);
    }

    @RequestMapping("/listDept.json")
    public Result listDept() {
        List<DeptPO> treeNodes = deptService.listDept();
        return Result.success(treeNodes);
    }

    @RequestMapping("/updateDept.json")
    public Result updateDept(DeptDTO deptDTO) {
        deptService.updatDeptById(deptDTO);
        return Result.success();
    }
}
