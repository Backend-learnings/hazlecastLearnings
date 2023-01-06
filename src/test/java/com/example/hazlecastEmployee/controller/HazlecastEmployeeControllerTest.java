package com.example.hazlecastEmployee.controller;


import com.example.hazlecastEmployee.entity.HazlecastEmployee;
import com.example.hazlecastEmployee.generic.HubResponse;
import com.example.hazlecastEmployee.generic.HubStatusCode;
import com.example.hazlecastEmployee.service.HazlecastEmployeeServiceImpl;
import com.example.hazlecastEmployee.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class HazlecastEmployeeControllerTest {

  @InjectMocks
  HazlecastEmployeeController hazlecastEmployeeController;

  @Mock
  HazlecastEmployeeServiceImpl hazlecastEmployeeService;

  private MockMvc mockMvc;

  private HubResponse<HazlecastEmployee> hubResponseFailure;
  private HubResponse<HazlecastEmployee> hubResponseSuccess;
  private static ObjectMapper mapper = new ObjectMapper();
  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(hazlecastEmployeeController).build();;
    hubResponseFailure = new HubResponse<>(HubStatusCode.BAD_REQUEST);
    hubResponseSuccess = new HubResponse<>(HubStatusCode.SUCCESS);

  }

  @Test
  public void test_getAllHazlecastEmployees() {

  }

  @Test
  public void getHazlecastEmployeeById_invalidId_test() throws Exception {
    Mockito.when(hazlecastEmployeeService.findHazlecastEmployeeById(1)).thenReturn(hubResponseFailure);
    mockMvc.perform(get("/hazlecastEmployee/1"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.status.code", is(HubStatusCode.BAD_REQUEST.getCode())));
    Mockito.verify(hazlecastEmployeeService).findHazlecastEmployeeById(1);
  }

  @Test
  public void getHazlecastEmployeeById_successId_test() throws Exception {
    Mockito.when(hazlecastEmployeeService.findHazlecastEmployeeById(1)).thenReturn(hubResponseSuccess);
    mockMvc.perform(get("/hazlecastEmployee/1"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.status.code", is(HubStatusCode.SUCCESS.getCode())));
    Mockito.verify(hazlecastEmployeeService).findHazlecastEmployeeById(1);
  }

  @Test
  public void update_hazlecastEmployee_for_id_success() throws Exception {
    HazlecastEmployee employee = TestUtils.getObject();
    HubResponse<HazlecastEmployee> hubResponseSuccess = new HubResponse<>(employee,HubStatusCode.SUCCESS);
    Mockito.when(hazlecastEmployeeService.updateHazlecastEmployeeById(Mockito.anyInt(),Mockito.any(HazlecastEmployee.class))).thenReturn(hubResponseSuccess);

    mockMvc.perform(MockMvcRequestBuilders.put("/hazlecastEmployee/update/44")
            .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(employee)))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(jsonPath("$.status.desc", is(HubStatusCode.SUCCESS.getDesc())));
    Mockito.verify(hazlecastEmployeeService).updateHazlecastEmployeeById(44,employee);
  }


  @Test
  public void deleteHazlecast_employee_by_id_success() throws Exception {
    Mockito.when(hazlecastEmployeeService.deleteHazlecastEmployee(1)).thenReturn("Deleted Successfully");
    mockMvc.perform(delete("/hazlecastEmployee/1"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk()).andReturn();
    Mockito.verify(hazlecastEmployeeService).deleteHazlecastEmployee(1);
  }



  @After
  public void tearDown() {
    Mockito.reset(hazlecastEmployeeService);
    Mockito.verifyNoMoreInteractions(hazlecastEmployeeService);
  }

}
