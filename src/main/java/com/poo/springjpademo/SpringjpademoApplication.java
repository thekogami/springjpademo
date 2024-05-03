package com.poo.springjpademo;

import com.poo.springjpademo.entity.Disciplina;
import com.poo.springjpademo.entity.Professor;
import com.poo.springjpademo.repository.DisciplinaRepository;
import com.poo.springjpademo.repository.ProfessorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;


@SpringBootApplication
public class SpringjpademoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringjpademoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringjpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProfessorRepository repository, DisciplinaRepository disciplinaRepository) {

		return (args) -> {
			repository.save(new Professor("Leanderson"));
			repository.save(new Professor("Paulo"));
			repository.save(new Professor("Vanessa"));
			log.info("-------------------------------");
			log.info(" findAll");
			for(var p : repository.findAll()){
				log.info(p.toString());
			}
			log.info("-------------------------------");
			log.info(" findAllOrderByNomeDesc");
			for(var p : repository.findAll(Sort.by(Sort.Direction.DESC,"nome"))){
				log.info(p.toString());
			}
			log.info("-------------------------------");
			log.info(" findById");
			var p = repository.findById(1L);
			log.info(p.toString());
			log.info("-------------------------------");
			log.info(" findByINome");
			 p = repository.findByNome("Vanessa");
			log.info(p.toString());
			p = repository.findById(1L);
			disciplinaRepository.save(new Disciplina("Poo 1", p.get()));
			disciplinaRepository.save(new Disciplina("Poo 2", p.get()));
			disciplinaRepository.save(new Disciplina("PCE", p.get()));

			p = repository.findById(2L);
			disciplinaRepository.save(new Disciplina("IA", p.get()));
			disciplinaRepository.save(new Disciplina("Redes", p.get()));
			log.info("-------------------------------");
			log.info(" Disciplinas");
			for(var d : disciplinaRepository.findAll()){
				log.info(d.toString());
			}
			p = repository.findById(3L);
			log.info("-------------------------------");
			log.info(" Disciplinas do professor paulo");
			for(var d : disciplinaRepository.findAllByProfessor(p.get())){
				log.info(d.toString());
			}
		};
	}

}
