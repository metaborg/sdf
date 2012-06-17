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

@SuppressWarnings("all") final class lifted584 extends Strategy 
{ 
  TermReference v_33018;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2063:
    { 
      term = aux_$Current$File_0_1.instance.invoke(context, term, v_33018.value);
      if(term == null)
        break Fail2063;
      if(true)
        return term;
    }
    return null;
  }
}