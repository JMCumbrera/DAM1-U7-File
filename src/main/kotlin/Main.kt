package un7

import kotlin.jvm.JvmStatic
import java.io.File
import java.util.*

object E02RutaRelativaAbsoluta {
    @JvmStatic
    fun main(args: Array<String>) {
        // Dos rutas absolutas
        val carpetaAbs = File("/tmp/fotos")
        val archivoAbs = File("/tmp/albania1.jpg")

        // Dos rutas relativas
        val carpetaRel = File("./Temp/trabajos")
        val fitxerRel = File("./Temp/trabajos/documento.txt")

        // Mostremos sus rutas
        mostrarRutas(carpetaAbs)
        mostrarRutas(archivoAbs)
        mostrarRutas(carpetaRel)
        mostrarRutas(fitxerRel)
    }

    fun mostrarRutas(f: File) {
        println("getParent(): " + f.parent)
        println("getName(): " + f.name)
        println("getAbsolutePath(): " + f.absolutePath)
    }
}

object E01ExisteYTipo {
    @JvmStatic
    fun main(args: Array<String>) {
        val temp = File("./Temp")
        val fotos = File("./Temp/Fotos")
        val document = File("./Temp/Documento.txt")
        println(temp.absolutePath + " ¿existe? " + temp.exists())
        mostrarEstado(fotos)
        mostrarEstado(document)
    }

    fun mostrarEstado(f: File) {
        println(f.absolutePath + " ¿archivo? " + f.isFile)
        println(f.absolutePath + " ¿carpeta? " + f.isDirectory)
    }
}

object E03PropiedadesFicheroYDirectorios {
    @JvmStatic
    fun main(args: Array<String>) {
        val documento = File("./Temp/Documento.txt")
        println(documento.absolutePath)

        if (documento.exists()) {
            val milisegundos = documento.lastModified()
            val fecha = Date(milisegundos)
            println("Última modificación (ms)   : $milisegundos")
            println("Última modificación (fecha): $fecha")
            println("Tamaño del archivo: " + documento.length())
        }
        else
            println("No existe el documento.")
    }
}

object E04CreaBorraDirectorios {
    @JvmStatic
    fun main(args: Array<String>) {
        val fotos = File("./Temp/Fotos")
        val doc = File("./Temp/Documento.txt")
        val mkdirFot: Boolean = fotos.mkdir()
        val createDoc: Boolean = doc.createNewFile()
        if (mkdirFot && createDoc) {
            println("Creada carpeta " + fotos.getName()+ "? " + mkdirFot)
            println("Creado archivo " + doc.name + "? " + createDoc)
        } else {
            val delCa: Boolean = fotos.delete()
            println("Borrada carpeta " + fotos.getName() + "? " + delCa)
            val delAr: Boolean = doc.delete()
            println("Borrado archivo " + doc.getName()+ "? " + delAr)
        }
    }
}

object E05RenombraFicheroYDirectorios {
    @JvmStatic
    fun main(args: Array<String>) {
        val origenDir = File("./Temp/Fotos")
        val destinoDir = File("./Temp/Media/Fotografies")
        val origenDoc = File("./Temp/Media/Fotografies/Document.txt")
        val destinoDoc = File("./Temp/Document.txt")
        var res = origenDir.renameTo(destinoDir)
        println("Se ha movido y renombrado la carpeta? $res")
        res = origenDoc.renameTo(destinoDoc)
        println("Se ha movido el documento? $res")
    }
}

object E06ListaContenidoDirectorio {
    @JvmStatic
    fun main(args: Array<String>) {
        val dir = File("./Temp")
        val lista = dir.listFiles()
        println("Contenido de " + dir.absolutePath + " :")

        // Recorremos el array y mostramos el nombre de cada elemento
        for (i in lista.indices) {
            val f = lista[i]
            if (f.isDirectory) {
                println("[DIR] " + f.name)
            } else {
                println("[ARX] " + f.name)
            }
        }
    }
}