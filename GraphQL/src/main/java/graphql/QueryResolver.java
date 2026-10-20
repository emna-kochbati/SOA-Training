package graphql;

// Import the business logic class responsible for managing "UniteEnseignement" data

import business.UniteEnseignementBusiness;

// Import the GraphQL library class used to define the root of GraphQL queries
import com.coxautodev.graphql.tools.GraphQLRootResolver;

// Import the entity class that represents a Teaching Unit (Unité d’Enseignement)
import entities.UniteEnseignement;

import java.util.List;

/**
 * This class acts as the root resolver for GraphQL queries.
 * It tells GraphQL how to fetch data when a query is executed.
 * <p>
 * In this example, it handles queries related to "UniteEnseignement".
 */
public class QueryResolver implements GraphQLRootResolver {

    // Attribute used to call the business logic layer (service) for data operations
    public UniteEnseignementBusiness helper;

    /**
     * Constructor of the resolver.
     * It initializes the business helper that provides methods to retrieve UE data.
     */
    public QueryResolver() {
        helper = new UniteEnseignementBusiness();
    }

    /**
     * GraphQL Query: allUEs
     * <p>
     * This method will be automatically exposed to the GraphQL schema as a query named "allUEs".
     * <p>
     * When a client sends the GraphQL query:
     * <p>
     * query {
     * allUEs {
     * code
     * domaine
     * }
     * }
     * <p>
     * GraphQL will call this method to return a list of "UniteEnseignement" objects.
     *
     * @return List of all Teaching Units (Unité d’Enseignement)
     */
    public List<UniteEnseignement> allUEs() {
        // Delegates the request to the business layer method getListeUE()
        // which fetches all UE entities (e.g., from a database or a static list)
        return helper.getListeUE();
    }

    public UniteEnseignement getUeByCode(int code) {
        return helper.getUEByCode(code);
    }

    public List<UniteEnseignement> getUeBysemestre(int semestre) {
        return helper.getUEBySemestre(semestre);
    }
}

