package com.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bank.entity.AccountEntity;
import com.bank.model.AccountDTO;

@Mapper
public interface AccountMapper {

	AccountDTO toDto(AccountEntity entity);

	AccountEntity toEntity(AccountDTO dto);
	
    List<AccountDTO> toDtoList(List<AccountEntity> entityList);

    List<AccountEntity> toEntityList(List<AccountDTO> dtoList);
}
