package webapp_JDF;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("booleanValidator")
public class booleanValidator implements Validator {

	public void validate(FacesContext ctx, UIComponent uiComponent, Object value) 
		      throws ValidatorException {
		    // Puisque ce validateur est utilisé avec un h:selectBooleanCheckbox, 
		    // on s'attend à ce que value soit de type Boolean.
		    if (! Boolean.TRUE.equals(value)) {
		      // Si la valeur n'est pas true, le validateur signale une ValidatorException.
		      // Le message d'erreur du validateur est directement extrait de l'attribut
		      // validatorMessage du composant dans la facelet.
		      UIInput uiInput = (UIInput) uiComponent;
		      throw new ValidatorException(new FacesMessage(uiInput.getValidatorMessage()));
		    }
		  }


}