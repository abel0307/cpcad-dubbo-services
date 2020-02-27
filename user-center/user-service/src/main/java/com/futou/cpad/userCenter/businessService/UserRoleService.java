package com.futou.cpad.userCenter.businessService;

import com.futou.cpcad.userCenter.db.dao.UserRoleMapper;
import com.futou.cpcad.userCenter.db.domain.UserRole;
import com.futou.cpcad.userCenter.db.domain.UserRoleExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.futou.cpad.userCenter.constant.ConstantEnum.STATUS_INVALID;


@Transactional
@Service
public class UserRoleService {

  private final UserRole.Column[] result = new UserRole.Column[] {
      UserRole.Column.id,
      UserRole.Column.roleName,
      UserRole.Column.roleCode,
      UserRole.Column.status
  };

  @Resource
  private UserRoleMapper userRoleMapper;

  public long countByRoleCode(String roleCode) {
    UserRoleExample example = new UserRoleExample();
    example.createCriteria().andRoleCodeEqualTo(roleCode);
    return userRoleMapper.countByExample(example);
  }

  public UserRole findUserRole(String roleCode) {
    UserRoleExample example = new UserRoleExample();
    example.createCriteria().andRoleCodeEqualTo(roleCode);
    return userRoleMapper.selectOneByExampleSelective(example, result);
  }

  public UserRole findById(Long id) {
    return userRoleMapper.selectByPrimaryKeySelective(id, result);
  }

  public int deleteById(Long id) {
    UserRole userRole = new UserRole();
    userRole.setId(id);
    userRole.setStatus(STATUS_INVALID.getValue()); /* 置为无效 */
    return userRoleMapper.updateByPrimaryKeySelective(userRole);
  }

  public int updateById(UserRole userRole) {
    return userRoleMapper.updateByPrimaryKeySelective(userRole);
  }

  public int add(UserRole userRole) {
    if (countByRoleCode(userRole.getRoleCode()) > 0) {
      return -1;
    }
    return userRoleMapper.insertSelective(userRole);
  }

}
