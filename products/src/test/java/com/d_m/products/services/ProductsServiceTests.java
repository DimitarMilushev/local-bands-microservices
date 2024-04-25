//package com.d_m.products.services;
//
//import com.d_m.products.dtos.AddProductDto;
//import com.d_m.products.mappers.ProductMapper;
//import com.d_m.products.models.BaseProductEntity;
//import jakarta.persistence.EntityExistsException;
//import jakarta.persistence.EntityNotFoundException;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.*;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//import com.d_m.products.repositories.ProductsRepository;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductsServiceTests {
//    @Mock
//    private ProductsRepository repository;
//    @Mock
//    private ProductMapper mapper;
//    @InjectMocks
//    private ProductsService service;
//
//    @Nested
//    class AddTests {
//        private final BaseProductEntity entity = BaseProductEntity.builder().name("TestProduct").build();
//        private final AddProductDto addProductDto =
//                AddProductDto.builder()
//                        .name("PRODUCT_NAME")
//                        .description("SOME DESCRIPTION IPSUM LOREM")
//                        .images(new String[]{})
//                        .SKU("SOME SKU")
//                        .categoryId(1L)
//                        .build();
//
//        @Test
//        void shouldThrowOnExistingSKU() {
//            when(repository.existsBySKU(any())).thenReturn(true);
//
//            assertThrowsExactly(EntityExistsException.class, () -> service.add(addProductDto));
//        }
//
//        @Test
//        void shouldCallSaveWithMappedEntity() {
//            final var expected = entity;
//            final ArgumentCaptor<BaseProductEntity> saveArgCaptor = ArgumentCaptor.forClass(BaseProductEntity.class);
//            when(repository.existsBySKU(any())).thenReturn(false);
//            when(mapper.addProductDtoToProductEntity(addProductDto)).thenReturn(expected);
//
//            service.add(addProductDto);
//
//            verify(repository).save(saveArgCaptor.capture());
//            assertEquals(expected, saveArgCaptor.getValue());
//        }
//
//        @Test
//        void shouldReturnTheSavedEntity() {
//            when(repository.existsBySKU(any())).thenReturn(false);
//            when(mapper.addProductDtoToProductEntity(any())).thenReturn(entity);
//            final BaseProductEntity saved = BaseProductEntity.builder()
//                    .name(entity.getName())
//                    .id(1L)
//                    .build();
//            when(repository.save(entity)).thenReturn(saved);
//
//            final var result = service.add(addProductDto);
//
//            assertEquals(saved, result);
//        }
//    }
//
//    @Nested
//    class FindByIdTests {
//        @Test
//        void shouldThrowIfNotFound() {
//            when(repository.findById(anyLong())).thenReturn(Optional.empty());
//
//            assertThrowsExactly(EntityNotFoundException.class, () -> service.findById(1L));
//        }
//
//        @Test
//        void shouldReturnFindByIdResult() {
//            final BaseProductEntity expected = BaseProductEntity.builder()
//                    .id(1L)
//                    .name("Gosho")
//                    .build();
//            when(repository.findById(1L)).thenReturn(Optional.of(expected));
//
//            final var result = service.findById(1L);
//
//            assertEquals(expected, result);
//        }
//    }
//
//    @Nested
//    class GetAllTests {
//        @Test
//        void shouldReturnFindAllResults() {
//            final ArrayList<BaseProductEntity> expected = new ArrayList<BaseProductEntity>();
//            expected.add(BaseProductEntity.builder().id(1L).build());
//            expected.add(BaseProductEntity.builder().id(2L).build());
//            when(repository.findAll()).thenReturn(expected);
//
//            final ArrayList<BaseProductEntity> result = (ArrayList<BaseProductEntity>) service.getAll();
//
//            verify(repository).findAll();
//            assertArrayEquals(result.toArray(), expected.toArray());
//        }
//    }
//}
