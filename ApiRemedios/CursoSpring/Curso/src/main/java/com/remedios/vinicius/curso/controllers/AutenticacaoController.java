package com.remedios.vinicius.curso.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.vinicius.curso.infra.DadosTokenJWT;
import com.remedios.vinicius.curso.infra.TokenService;
import com.remedios.vinicius.curso.usuarios.DadosAutenticacao;
import com.remedios.vinicius.curso.usuarios.Usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager maneger;
	
	
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping
	public ResponseEntity<?> efetuarLogin (@RequestBody @Valid DadosAutenticacao dados){
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var autenticacao = maneger.authenticate(token);
		
		var tokenJWT = tokenService.gerartoken((Usuario) autenticacao.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}
	
}
