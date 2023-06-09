package com.example.backend.api.controller;


import com.example.backend.dto.CMRespDto;
import com.example.backend.dto.PlaceDto;
import com.example.backend.dto.UserDto;
import com.example.backend.service.PlaceService;
import com.example.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;



    @PostMapping("")
    public ResponseEntity<?> register(
            @Valid @RequestBody PlaceDto.PostRequest dto
    ){
        //
        placeService.registerPlace(dto);
        return new ResponseEntity<>(new CMRespDto<>(1, "장소 등록이 완료되었습니다", null), HttpStatus.CREATED);

    }

    @DeleteMapping("/{place_id}")
    public String deletePlace(@PathVariable Long place_id) {
        placeService.delete(place_id);
        return "장소가 삭제되었습니다.";
    }
}
