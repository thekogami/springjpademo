package com.poo.springjpademo;

import com.poo.springjpademo.entity.*;
import com.poo.springjpademo.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import com.poo.springjpademo.entity.Curso;
import com.poo.springjpademo.entity.Turma;
import com.poo.springjpademo.entity.Sala;
import com.poo.springjpademo.repository.CursoRepository;
import com.poo.springjpademo.repository.TurmaRepository;
import com.poo.springjpademo.repository.SalaRepository;


@SpringBootApplication
public class SpringjpademoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringjpademoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringjpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProfessorRepository repository,
								  DisciplinaRepository disciplinaRepository,
								  CursoRepository cursoRepository,
								  TurmaRepository turmaRepository,
								  SalaRepository salaRepository,
								  GradeHorariaRepository gradeHorariaRepository) {

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
			cursoRepository.save(new Curso("Curso 1"));
			cursoRepository.save(new Curso("Curso 2"));
			log.info("-------------------------------");
			log.info(" Cursos");
			for(var c : cursoRepository.findAll()){
				log.info(c.toString());
			}

			turmaRepository.save(new Turma("Turma 1"));
			turmaRepository.save(new Turma("Turma 2"));
			log.info("-------------------------------");
			log.info(" Turmas");
			for(var t : turmaRepository.findAll()){
				log.info(t.toString());
			}

			salaRepository.save(new Sala("Sala 1"));
			salaRepository.save(new Sala("Sala 2"));
			log.info("-------------------------------");
			log.info(" Salas");
			for(var s : salaRepository.findAll()){
				log.info(s.toString());
			}

			gradeHorariaRepository.save(new GradeHoraria("Grade 1"));
			gradeHorariaRepository.save(new GradeHoraria("Grade 2"));
			log.info("-------------------------------");
			log.info(" GradeHoraria");
			for(var g : gradeHorariaRepository.findAll()){
				log.info(g.toString());
			}
		};
	}

}
