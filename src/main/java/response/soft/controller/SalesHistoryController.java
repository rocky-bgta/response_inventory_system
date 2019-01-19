package response.soft.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.soft.core.RequestMessage;
import response.soft.core.ResponseMessage;
import response.soft.model.StoreOutProductModel;
import response.soft.services.SalesHistoryService;

import java.util.UUID;

@RestController
@RequestMapping("api/store-sales-products")
@Api(tags = "Sales History Api List")
public class SalesHistoryController {

    @Autowired
    private SalesHistoryService salesHistoryService;


    @ApiOperation(value ="", response = Object.class)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAll(@RequestBody RequestMessage requestMessage){
        ResponseMessage responseMessage;
        responseMessage = this.salesHistoryService.getAllStoreSalesProducts(requestMessage);
        return responseMessage;
    }

    @ApiOperation(value ="", response = Object.class)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getById(@PathVariable UUID id){
        ResponseMessage responseMessage;
        responseMessage = this.salesHistoryService.getByStoreSalesProductsId(id);
        return responseMessage;
    }

    @ApiOperation(value ="", response = StoreOutProductModel.class)
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) {
        ResponseMessage responseMessage;
        responseMessage = this.salesHistoryService.saveStoreSalesProducts(requestMessage);
        return responseMessage;
    }

    @ApiOperation(value ="", response = StoreOutProductModel.class)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage update(@RequestBody RequestMessage requestMessage) {
        ResponseMessage responseMessage;
        responseMessage = this.salesHistoryService.updateStoreSalesProducts(requestMessage);
        return responseMessage;
    }

    @ApiOperation(value ="", response = StoreOutProductModel.class)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> delete(@PathVariable UUID id) {
        ResponseMessage responseMessage;
        responseMessage = this.salesHistoryService.deleteStoreSalesProducts(id);
        return new ResponseEntity(responseMessage,HttpStatus.OK);
    }

    @ApiOperation(value ="", response = Object.class)
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/invoice-no/{invoiceNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getSalesHistoryByInvoiceNo(@PathVariable String invoiceNo){
        ResponseMessage responseMessage;
        responseMessage = this.salesHistoryService.getSalesHistoryByInvoiceNo(invoiceNo);
        return responseMessage;
    }
}