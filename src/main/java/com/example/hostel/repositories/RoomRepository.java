/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hostel.repositories;

import java.util.Collection;
import java.util.List;
//import java.util.List;
//import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.query.Modifying;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import com.example.hostel.models.Room;
import org.springframework.transaction.annotation.Transactional;

@ComponentScan
public interface RoomRepository extends JpaRepository<Room, Integer> {


	@Query("SELECT DISTINCT room FROM Room room")
	@Transactional(readOnly = true)
	Collection<Room> findByMatrik(@Param("matrik") String matrik);


	
	@Query("SELECT room FROM Room room WHERE room.id =:id")
	@Transactional(readOnly = true)
	Optional<Room> findById(@Param("id") Integer id);


	@Transactional
    @Modifying
    @Query(value = "UPDATE room r set name =:name, matrik =:matrik, email =:email, block =:block, roomno=:roomno",
                    nativeQuery = true)
	 // DEFINED THE NATIVE QUERY FOR UPDATE INSTEAD OF USING SAVE() OPERATION            
	void updateRoom(@Param("name") String name,@Param("matrik") String matrik,@Param("email") String email,@Param("block") String block, @Param("roomno") String roomno);

	//List<Room> search(String matrik);


	@Query(value = "SELECT room FROM Room room WHERE room.name LIKE '%' || :keyword || '%'"
	+ " OR room.matrik LIKE '%' || :keyword || '%'"
	+ " OR room.email LIKE '%' || :keyword || '%'"
	+ " OR room.block LIKE '%' || :keyword || '%'"
	+ " OR room.roomno LIKE '%' || :keyword || '%'")
	public List<Room> search(@Param("keyword") String keyword);






}
