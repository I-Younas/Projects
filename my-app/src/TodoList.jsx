import React, { useState } from "react";
import Todo from "./Todo.jsx"

function TodoList({todos,setTodos}) {
    
    return (
<div className="todo-container">
    <ul className="todo-list">
        {todos.map(todo => (
            <Todo setTodos= {setTodos} todos={todos} todo={todo} text={todo.text} key={todo.id}/>
        ))}
    </ul>
</div>
    );
}

export default TodoList;
