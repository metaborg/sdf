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

@SuppressWarnings("all") final class lifted62 extends Strategy 
{ 
  TermReference u_10735;

  TermReference v_10735;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail208:
    { 
      term = aux_$Is$Imported_0_2.instance.invoke(context, term, u_10735.value, v_10735.value);
      if(term == null)
        break Fail208;
      if(true)
        return term;
    }
    return null;
  }
}