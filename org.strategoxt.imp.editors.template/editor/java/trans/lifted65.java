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

@SuppressWarnings("all") final class lifted65 extends Strategy 
{ 
  TermReference r_10736;

  TermReference s_10736;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail205:
    { 
      term = aux_$Is$Imported_0_2.instance.invoke(context, term, r_10736.value, s_10736.value);
      if(term == null)
        break Fail205;
      if(true)
        return term;
    }
    return null;
  }
}