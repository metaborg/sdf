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

@SuppressWarnings("all") final class lifted63 extends Strategy 
{ 
  TermReference b_10736;

  TermReference c_10736;

  TermReference d_10736;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail207:
    { 
      term = aux_$Is$Imported_0_2.instance.invoke(context, term, b_10736.value, c_10736.value);
      if(term == null)
        break Fail207;
      if(d_10736.value == null)
        d_10736.value = term;
      else
        if(d_10736.value != term && !d_10736.value.match(term))
          break Fail207;
      if(true)
        return term;
    }
    return null;
  }
}