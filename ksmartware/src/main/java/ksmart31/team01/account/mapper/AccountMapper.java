package ksmart31.team01.account.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart31.team01.member.domain.Account;



@Mapper
public interface AccountMapper {
	//account 리스트
	public List<Account> selectAccountList();
}
