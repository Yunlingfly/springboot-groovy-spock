//  Groovy字符串
def name = "mickjoust"
def amount = 250
println('My name is ${name}')
println("My name is ${name}")
println("He paid \$${amount}")

//使用单引号换行编写
def content = '''My Name is mickjoust.
    I live in china.
    I am a software developer'''

def aaa = 'mickjoust'
def address = 'china'
def occupation = 'software developer'
//使用双引号换行编写
def bio = """My name is ${aaa}.
        I live in ${address}.
        I am a ${occupation}."""
println(bio)


//  POJO属性
class Person
{
    def id
    def name
    def email
}
def p = new Person()
p.id = 1
p.name = 'mickjoust'
p.email = 'mickjoust@test.com'
println("Id: ${p.id}, Name: ${p.name}, Email: ${p.email}")

//  循环用法
for(i in 0..5) { print "${i} " }
println()
0.upto(5) { print "$it " }
println()
5.times { print "$it " }
println()
0.step(10, 2) { print "$it "}