import React, {useState} from "react";
import "./index.css"
import Form from "./Form.jsx"
import TodoList from "./TodoList"
import "./App.css";

function App() {

  const [inputText,setInputText ] = useState("")
  const [todos,setTodos]=useState([]);

  return (
    <div>
      
      <div>
        <Form inputText={inputText} todos={todos} setTodos={setTodos} setInputText={setInputText}/>
        <TodoList setTodos={setTodos} todos={todos} />
      </div>

    </div>
  );
}

export default App;
