package com.example.demo.services;

import com.example.demo.dto.MediaDTO;
import com.example.demo.dto.MessageDTO;
import com.example.demo.dto.PriceDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Media;
import com.example.demo.entities.Price;
import com.example.demo.entities.Product;
import com.example.demo.producers.CatalogProducer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CatalogProducer catalogProducer;

    private ProductDTO mapProductToProductDTO() {
        Product product = new Product();

        product.setName("Product");
        product.setDescription("Description");
        product.setQuantity(1);

        return modelMapper.map(product, ProductDTO.class);
    }

    private PriceDTO mapPriceToPriceDTO() {
        Price price = new Price();

        price.setValue(BigDecimal.TEN);
        price.setCurrency("BRL");

        return modelMapper.map(price, PriceDTO.class);
    }

    private MediaDTO mapMediaToMediaDTO() {
        Media media = new Media();

        media.setName("Media");
        media.setUrl("http://example.com");
        media.setType("image");

        return modelMapper.map(media, MediaDTO.class);
    }

    public MessageDTO getMessageDTO() {
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setProduct(mapProductToProductDTO());
        messageDTO.setPrice(mapPriceToPriceDTO());
        messageDTO.setMedia(mapMediaToMediaDTO());

        return catalogProducer.sendMessage(messageDTO);
    }

    public MessageDTO getMessageDTOWithNullProduct() {
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setProduct(null);
        messageDTO.setPrice(mapPriceToPriceDTO());
        messageDTO.setMedia(mapMediaToMediaDTO());

        return catalogProducer.sendMessage(messageDTO);
    }

    public MessageDTO getMessageDTOWithNullPrice() {
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setProduct(mapProductToProductDTO());
        messageDTO.setPrice(null);
        messageDTO.setMedia(mapMediaToMediaDTO());

        return catalogProducer.sendMessage(messageDTO);
    }

    public MessageDTO getMessageDTOWithNullMedia() {
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setProduct(mapProductToProductDTO());
        messageDTO.setPrice(mapPriceToPriceDTO());
        messageDTO.setMedia(null);

        return catalogProducer.sendMessage(messageDTO);
    }

    public MessageDTO getMessageDTOWithNullProductAndPrice() {
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setProduct(null);
        messageDTO.setPrice(null);
        messageDTO.setMedia(mapMediaToMediaDTO());

        return catalogProducer.sendMessage(messageDTO);
    }

    public MessageDTO getMessageDTOWithNullProductAndMedia() {
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setProduct(null);
        messageDTO.setPrice(mapPriceToPriceDTO());
        messageDTO.setMedia(null);

        return catalogProducer.sendMessage(messageDTO);
    }

    public MessageDTO getMessageDTOWithNullPriceAndMedia() {
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setProduct(mapProductToProductDTO());
        messageDTO.setPrice(null);
        messageDTO.setMedia(null);

        return catalogProducer.sendMessage(messageDTO);
    }

}
