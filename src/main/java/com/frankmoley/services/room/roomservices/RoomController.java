package com.frankmoley.services.room.roomservices;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Room> findAll(@RequestParam(name = "rootNumber",required = false) String roomNumber){
        if(StringUtils.isNoneEmpty(roomNumber)){
            return Collections.singletonList(this.roomRepository.findByRoomNumber(roomNumber));
        }
        return (List<Room>) this.roomRepository.findAll();

    };

}
