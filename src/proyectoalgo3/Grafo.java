package proyectoalgo3;
/**
 * Clase grafo
 * @author Julián González Piedra 2019036457
 */
public final class Grafo {

    private final int MAX_VERTICES;
    private final int MAX_ARISTAS;
    private int nroAristas;
    private int grafo[][];

    /**
     * Crea un grafo vacío, con un máximo numero de vertices y aristas
     * @param nroVertices
     * @param nroAristas 
     */
    public Grafo(int nroVertices, int nroAristas) {
        MAX_VERTICES = nroVertices;
        MAX_ARISTAS = nroAristas;

        this.nroAristas = 0;

        grafo = new int[MAX_VERTICES][MAX_VERTICES];

        for (int i = 0; i < getMAX_VERTICES(); i++) {
            for (int j = 0; j < getMAX_VERTICES(); j++) {
                grafo[i][j] = 0;
            }
        }
    }

    /**
     * Crea un grafo vacío, con un máximo número de vertices, y vertices al cuadrado como número máximo de aristas.
     * @param nroVertices 
     */
    public Grafo(int nroVertices) {
        //Llamada al constructor con dos argumentos
        this(nroVertices, nroVertices);
    }

/**
 *Crea un grafo vacío con un máximo número de vertices 5 y máximo numero de aristas = 25.
 */
    public Grafo() {
        //Llamada al constructor con dos argumentos
        this(20, 20);
    }
/**
 * Retorna el maximo de vertices
 * @return 
 */
    public int getMAX_VERTICES() {
        return MAX_VERTICES;
    }
/**
 * Retorna el maximo de aristas
 * @return 
 */
    public int getMAX_ARISTAS() {
        return MAX_ARISTAS;
    }

    /**
     * Inserta una arista entre dirigida del vertice v1 al vertice v2
     * @param v1
     * @param v2
     * @param Peso
     * @throws ArrayIndexOutOfBoundsException
     * @throws UnsupportedOperationException 
     */
    public void insertaArista(int v1, int v2, int Peso)
            throws ArrayIndexOutOfBoundsException, UnsupportedOperationException {
        if (v1 >= MAX_VERTICES || v2 >= MAX_VERTICES) {
            throw new ArrayIndexOutOfBoundsException("Vertices inválidos, fuera de rango"
                    + "\nRango de vertices: 0 - " + (getMAX_VERTICES() - 1));
        } else if (nroAristas == MAX_ARISTAS) {
            throw new UnsupportedOperationException("No se puede añadir más aristas");
        } else {
            grafo[v1][v2] += Peso;
        }
    }

    /**
     * Retorna verdadero si existe una arista dirigida entre los vertices v1 y v2
     * @param v1
     * @param v2
     * @return 
     */
    public boolean existeArista(int v1, int v2) {
        if (v1 >= MAX_VERTICES || v2 >= MAX_VERTICES) {
            throw new ArrayIndexOutOfBoundsException("Vertices inválidos, fuera de rango"
                    + "\nRango de vertices: 0 - " + (getMAX_VERTICES() - 1));
        } else if (grafo[v1][v2] == 1) {
            return true;
        }
        return false;
    }

    /**
     * Elimina la arista entre los vertices v1 y v2
     * @param v1
     * @param v2 
     */
    public void eliminaArista(int v1, int v2) {
        if (v1 >= MAX_VERTICES || v2 >= MAX_VERTICES) {
            throw new ArrayIndexOutOfBoundsException("Vertices inválidos, fuera de rango"
                    + "\nRango de vertices: 0 - " + (getMAX_VERTICES() - 1));
        } else if (grafo[v1][v2] == 0) {
            System.err.println("La arista NO existe");
        } else {
            grafo[v1][v2] = 0;
        }
    }

    /**
     * Elimina todas las aristas. Se llena toda la matriz de ceros
     */
    public void liberaGrafo() {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                grafo[i][j] = 0;
            }
        }
    }
/**
 * Muestra el grafo
 */
    public void mostrarGrafo() {
        System.out.print(" ");
        for (int i = 0; i < MAX_VERTICES; i++) {
            System.out.printf("  %3d", i);
        }
        System.out.println();
        for (int i = 0; i < MAX_VERTICES; i++) {
            System.out.printf(" %3d", i);
            for (int j = 0; j < MAX_VERTICES; j++) {
                System.out.printf(" %3d", grafo[i][j]);
            }
            System.out.println();
        }
    }
/**
 * Calcula la distancia de un vertice a otro
 * @param v1
 * @param v2
 * @return 
 */
    public String calcularDistancia(int v1, int v2) {
        if (v1 >= MAX_VERTICES || v2 >= MAX_VERTICES) {
            throw new ArrayIndexOutOfBoundsException("Vertices inválidos, fuera de rango"
                    + "\nRango de vertices: 0 - " + (getMAX_VERTICES() - 1));
        } else if (grafo[v1][v2] != 0) {
            System.out.println("La distancia es: "+grafo[v1][v2]);
            return " ";
        }
        System.out.println("La distancia es: 0");
        return " ";

    }

}
