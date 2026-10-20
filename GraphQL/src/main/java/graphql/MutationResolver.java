package graphql;

// Import the business logic class responsible for managing "UniteEnseignement" data
import business.UniteEnseignementBusiness;

// Import the GraphQL library class used to define the root of GraphQL mutations
import com.coxautodev.graphql.tools.GraphQLRootResolver;

// Import the entity class representing a Teaching Unit (Unité d’Enseignement)
import entities.UniteEnseignement;

/**
 * This class defines all GraphQL mutations related to the "UniteEnseignement" entity.
 * A mutation in GraphQL is used to perform write operations (create, update, delete)
 * as opposed to queries, which are for read operations.
 */
public class MutationResolver implements GraphQLRootResolver {

    // Attribute used to access the business logic (service layer)
    public UniteEnseignementBusiness helper;

    /**
     * Constructor of the resolver.
     * It initializes the business helper that manages the teaching units.
     */
    public MutationResolver() {
        helper = new UniteEnseignementBusiness();
    }

    /**
     * GraphQL Mutation: addUniteEnseignement
     *
     * This method allows clients to add a new "Unité d’Enseignement" to the system.
     *
     * When a GraphQL mutation like the following is executed:
     *
     * mutation {
     *     addUniteEnseignement(
     *         code: 101,
     *         domaine: "Informatique",
     *         responsable: "Dr. Smith",
     *         credits: 4,
     *         semestre: 2
     *     )
     * }
     *
     * GraphQL calls this Java method to create and save a new teaching unit.
     */
    public boolean addUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        // Create a new UniteEnseignement object with the provided parameters
        UniteEnseignement ue = new UniteEnseignement(code, domaine, responsable, credits, semestre);

        // Call the business logic method to add the new unit
        // The helper handles the actual persistence or logic of adding the entity
        return helper.addUniteEnseignement(ue);
    }
    public boolean updateUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre){
        UniteEnseignement ue = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        return helper.updateUniteEnseignement(code,ue);
    }

    public boolean deleteUniteEnseignement(int code) {
        return helper.deleteUniteEnseignement(code);
    }

}
