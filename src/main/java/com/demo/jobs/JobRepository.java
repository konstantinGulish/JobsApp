package com.demo.jobs;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Long> {
}
