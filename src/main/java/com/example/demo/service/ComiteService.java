package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comite;
import com.example.demo.model.Conferencia;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ComiteRepository;
import com.example.demo.repository.ConferenciaRepository;
import com.example.demo.repository.UsuarioRepository;

@Service
public class ComiteService {
	
	@Autowired
	ComiteRepository comiteRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ConferenciaRepository conferenciaRepository;
	
	
	public List<Comite> getAllComites(){
		return comiteRepository.findAll();
	}
	
	public void agregarComite(int idConferencia,Comite comite) {
		
		Optional<Conferencia> optConferencia = conferenciaRepository.findById(idConferencia);
		if(optConferencia.isPresent()) {
			Conferencia conferencia = optConferencia.get();
			comite.setConferencia(conferencia);
			comiteRepository.save(comite);
		}
	}
	
	public Comite agregarMiembrosComite(int idUsuario,int idComite){
		
		Comite comite = comiteRepository.findById(idComite)
                .orElseThrow(() -> new RuntimeException("Comité no encontrado"));


        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        comite.getUsuarios().add(usuario);
		
		comiteRepository.save(comite);
		
		return comite;
	}
	
	

}
