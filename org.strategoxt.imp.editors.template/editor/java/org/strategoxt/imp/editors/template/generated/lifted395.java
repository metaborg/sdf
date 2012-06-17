package org.strategoxt.imp.editors.template.generated;

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

@SuppressWarnings("all") final class lifted395 extends Strategy 
{ 
  TermReference x_32984;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1631:
    { 
      TermReference e_32985 = new TermReference();
      IStrategoTerm f_32985 = null;
      f_32985 = term;
      if(x_32984.value == null)
        break Fail1631;
      term = x_32984.value;
      if(e_32985.value == null)
        e_32985.value = term;
      else
        if(e_32985.value != term && !e_32985.value.match(term))
          break Fail1631;
      term = f_32985;
      IStrategoTerm term510 = term;
      Success609:
      { 
        Fail1632:
        { 
          if(term.getTermType() != IStrategoTerm.STRING || !"".equals(((IStrategoString)term).stringValue()))
            break Fail1632;
          if(true)
            break Success609;
        }
        term = term510;
        lifted396 lifted3960 = new lifted396();
        lifted3960.e_32985 = e_32985;
        term = templatelang_origin_track_forced_1_0.instance.invoke(context, term, lifted3960);
        if(term == null)
          break Fail1631;
      }
      if(true)
        return term;
    }
    return null;
  }
}