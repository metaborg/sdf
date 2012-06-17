package trans;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") final class lifted593 extends Strategy 
{ 
  TermReference a_33023;

  TermReference b_33023;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2054:
    { 
      term = aux_$Is$Imported_0_2.instance.invoke(context, term, a_33023.value, b_33023.value);
      if(term == null)
        break Fail2054;
      if(true)
        return term;
    }
    return null;
  }
}