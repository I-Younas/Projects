// typescript tutorial



let id: number = 5;
let company:string = 'Tra Med'
let isPublished: boolean = true
let x:any = 'hello'

let ids: number[] = [1,2,3,4,5]
let arr: any[] = [1,true,'Hello']

// Tuple
let person: [number,string,boolean] = [1,'Hi',false]

// Tuple Array
let per: [number,boolean] []

per = [],[2,true],[3,false]

// Union

let pid: string | number 
pid = '22'

// Enum
enum Direction1 {
    Up = 1,
    Down,
    Left,
    Right}

console.log(Direction1.Left); // this outputs 3


// Objects 
type User = {
    id: number
    name: string
} 

const user: User = {
    id: 1,
    name: 'John'
}

// Type Assertion (TypeCasting)
let cid: any =1 

// Two ways to Assert type below

// let customerId = <number>cid
// let customerId = cid as number

// Functions
function addNum(x: number,y: number): number { // parameter types and after colon we have return type
    return x + y
}


// Interfaces (Custom Type) - Can't use Interfaces with primitives or Unions
interface UserInterface {
    readonly id: number
    name: string
    age?:number // the ? tells you that this property is optional
} 

const user1: UserInterface = {
    id: 1,
    name: 'John'
}

// MathFunc only provides the skeleton of the function
interface MathFunc {
    (x: number, y: number): number
}

const add: MathFunc = (x: number, y:number ): number => x + y

interface PersonInterface {
    readonly id: number
    name: string
    age?:number // the ? tells you that this property is optional
    register(): string
} 

// Classes
class Person implements PersonInterface {
    id: number
    name: string 

    constructor(id: number, name: string) {
        this.id = id
        this.name = name
    }

    register(){
        return this.name + "is now registered"
    }

}

class Employee extends Person {
    position: string

    constructor(id:number, name: string, position: string){
        super(id,name)
        this.position = position
    }
}


// Generics
function getArray<T>(items: T[]): T[] {
    return new Array().concat(items)
}

let numArray = getArray<number>([1,2,3,4])
let strArray = getArray<string>(['brad','John','Jill'])

