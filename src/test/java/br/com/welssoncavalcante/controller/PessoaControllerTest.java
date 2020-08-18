package br.com.welssoncavalcante.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.welssoncavalcante.domain.Pessoa;
import br.com.welssoncavalcante.services.PessoaService;

@SpringBootTest
@AutoConfigureMockMvc
public class PessoaControllerTest {
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoaService pessoaService;
    
    @Autowired
    private ObjectMapper objectMapper;
	
	
	@Test
    public void case1() throws Exception{
        List<Pessoa> lista = new ArrayList<Pessoa>();
        Mockito.when(pessoaService.findAll()).thenReturn(lista);
        this.mockMvc.perform(get("/api/pessoas").contentType("application/json").
        		content(objectMapper.writeValueAsString(lista)))
        		.andExpect(status().isOk());
    }

	@Test
    public void case2() throws Exception{
        Pessoa pessoa = new Pessoa();
        pessoa.setId("5f342eb6af8813964649ea35");
        Mockito.when(pessoaService.findById(pessoa.getId())).thenReturn(pessoa).thenReturn(null);
        this.mockMvc.perform(get("/api/pessoas").contentType("application/json").
        		content(objectMapper.writeValueAsString(pessoa)))
        		.andExpect(status().isOk());
    }

	@Test
    public void case3() throws Exception{
        Mockito.when(pessoaService.create(new Pessoa())).thenReturn(new Pessoa());
        this.mockMvc.perform(post("/api/pessoas").contentType("application/json").
        		content(objectMapper.writeValueAsString(new Pessoa())))
        		.andExpect(status().isOk());
    }


}
