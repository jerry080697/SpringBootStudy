package umc.study.converter;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.JoinStoreResultDTO toJoinStoreResultDTO(Store store){
        return StoreResponseDTO.JoinStoreResultDTO.builder()
                .storeId(store.getStoreId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinStoreDto request){
        return Store.builder()
                .storeName(request.getStoreName())
                .description(request.getDescription())
                .category(request.getCategory())
                .address(request.getAddress())
                .earnablePoint(request.getEarnablePoint())

                .build();
    }
}