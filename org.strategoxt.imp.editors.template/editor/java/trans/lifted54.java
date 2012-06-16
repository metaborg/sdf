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

@SuppressWarnings("all") final class lifted54 extends Strategy 
{ 
  TermReference v_10731;

  TermReference w_10731;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail216:
    { 
      term = aux_$Current$File_0_1.instance.invoke(context, term, v_10731.value);
      if(term == null)
        break Fail216;
      if(w_10731.value == null)
        w_10731.value = term;
      else
        if(w_10731.value != term && !w_10731.value.match(term))
          break Fail216;
      if(true)
        return term;
    }
    return null;
  }
}