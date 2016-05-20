package webapp_JDF;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("MotdePasseValidator")
public class MotdePasseValidator implements Validator {

	public void validate(FacesContext ctx, UIComponent uiComponent, Object value) throws ValidatorException {
		// Puisque ce validateur est utilisé avec un h:selectBooleanCheckbox,
		// on s'attend à ce que value soit de type Boolean.

		Object motdepasse = uiComponent.getAttributes().get("motdepasse");

		if (!value.equals(motdepasse)) {
			throw new ValidatorException(new FacesMessage("les mots de passes ne sont pas identique !"));
		}

	}
}