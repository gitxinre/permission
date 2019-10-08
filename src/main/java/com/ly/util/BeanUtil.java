package com.ly.util;

import com.ly.entity.dto.UserDTO;
import com.ly.entity.po.UserPO;
import com.ly.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinre
 */
@Slf4j
public class BeanUtil {


    public static <S, T> T copyEntity2AnotherEntity(S sourceEntity, Class<T> targetEntityClass) {
        T t;
        try {
            t = targetEntityClass.newInstance();
            BeanUtils.copyProperties(t, sourceEntity);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new PermissionException(e.getMessage());
        }
        return t;
    }

    public static <S, T> List<T> copyEntityList2AnotherEntityList(List<S> sourceEntityList, Class<T> targetEntityClass) {
        if (CollectionUtils.isEmpty(sourceEntityList)) {
            return null;
        } else {
            List<T> targetEntityList = new ArrayList<T>();
            for (int i = 0, size = sourceEntityList.size(); i < size; i++) {
                try {
                    T t = targetEntityClass.newInstance();
                    BeanUtils.copyProperties(t, sourceEntityList.get(i));
                    targetEntityList.add(t);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    throw new PermissionException(e.getMessage());
                }
            }
            return targetEntityList;
        }
    }

    public static void main(String[] args) {
        UserDTO build = UserDTO.builder()
                .code("mfl")
                .deptId("001")
                .email("yf@qq.com")
                .remark("hgct")
                .status(1)
                .telephone("18812345678")
                .build();
        build.setId(IdGenerator.guid());
        build.setName("中国我爱你");
        build.setNameHeadChar(PinYinUtils.headChar(build.getName()));
        UserPO userPO = copyEntity2AnotherEntity(build, UserPO.class);
        System.out.println("userPO = " + userPO);
    }
}
