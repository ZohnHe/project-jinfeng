
package com.jfone.mall.base.Realm;



import com.jfone.mall.base.entity.work.ext.ExJfonePermission;
import com.jfone.mall.base.entity.work.ext.ExJfoneRole;
import com.jfone.mall.base.entity.work.ext.ExJfoneUser;
import com.jfone.mall.base.service.PermissionService;
import com.jfone.mall.base.service.RoleService;
import com.jfone.mall.base.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


//自定义Relm,实现安全数据的链接，由安全管理器调用realm

public class JfoneRealm extends AuthorizingRealm {


	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("授权管理");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Subject subject = SecurityUtils.getSubject();
		ExJfoneUser user = (ExJfoneUser) subject.getPrincipal();
		ExJfoneRole role = roleService.getRole(user.getuRoleid());
		authorizationInfo.addRole(role.getrKeyword());
		List<ExJfonePermission> permissions = permissionService.getPermissions(role.getId());
		for (ExJfonePermission per :permissions) {
			authorizationInfo.addStringPermission(per.getpKeyword());
		}
		return authorizationInfo;
	}


	/**
	 * 
	  * TODO 自定义realms，对比安全数据
	  * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(AuthenticationToken)
	 */
	// 认证....
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("验证开始");
		//转换token
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		System.out.println(usernamePasswordToken.getUsername());
		ExJfoneUser user = userService.searchUserByUsername(usernamePasswordToken.getUsername());
		if (user == null) {
			return null;
		} else {
			ByteSource credentialsSalt = ByteSource.Util.bytes(user.getuUsername());
			return new SimpleAuthenticationInfo(user, user.getuPassword(), credentialsSalt,getName());
		}
	}

}
