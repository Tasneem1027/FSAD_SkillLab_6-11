import React, { useState } from "react";
import "./StudentManager.css";

function StudentManager() {

  // Initial students
  const initialStudents = [
    { id: 1, name: "Aisha", course: "CSE" },
    { id: 2, name: "Rahul", course: "ECE" },
    { id: 3, name: "Sneha", course: "EEE" },
    { id: 4, name: "Arjun", course: "IT" },
    { id: 5, name: "Meena", course: "Civil" }
  ];

  // useState
  const [students, setStudents] = useState(initialStudents);

  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  // Handle input change
  const handleChange = (e) => {
    setNewStudent({
      ...newStudent,
      [e.target.name]: e.target.value
    });
  };

  // Add student
  const addStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) {
      alert("Please fill all fields");
      return;
    }

    setStudents([...students, newStudent]);

    // Clear inputs
    setNewStudent({
      id: "",
      name: "",
      course: ""
    });
  };

  // Delete student
  const deleteStudent = (id) => {
    const updatedStudents = students.filter((s) => s.id !== id);
    setStudents(updatedStudents);
  };

  return (
    <div className="container">
      <h2>Student Manager</h2>

      {/* Input fields */}
      <div className="form">
        <input
          type="number"
          name="id"
          placeholder="Enter ID"
          value={newStudent.id}
          onChange={handleChange}
        />

        <input
          type="text"
          name="name"
          placeholder="Enter Name"
          value={newStudent.name}
          onChange={handleChange}
        />

        <input
          type="text"
          name="course"
          placeholder="Enter Course"
          value={newStudent.course}
          onChange={handleChange}
        />

        <button onClick={addStudent}>Add Student</button>
      </div>

      {/* Display students */}
      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {students.map((s) => (
              <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.course}</td>
                <td>
                  <button
                    className="delete-btn"
                    onClick={() => deleteStudent(s.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default StudentManager;