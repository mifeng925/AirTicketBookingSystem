import com.bee.airsystem.entity.AviationSystem

class People {

    fun <T> class1(clazz: Class<T>){
        println(clazz.name)
        val declaredFields = clazz.declaredFields
        declaredFields.forEach {

//            println(it)
        }
//        val newInstance = clazz.newInstance()
    }


}

class Dog(){
    var name = ""

    fun say(){
        println("wang wang  wang ")
    }
}

fun main(args: Array<String>) {

    People().class1(AviationSystem::class.java)


//    val fromJson = Gson().fromJson<Dog>("")



}