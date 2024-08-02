package com.ctw.workstation.rack.control;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RackMapper {
    Rack toEntity(RackDto rackDto);
    RackDto toDto(Rack rack);
}
