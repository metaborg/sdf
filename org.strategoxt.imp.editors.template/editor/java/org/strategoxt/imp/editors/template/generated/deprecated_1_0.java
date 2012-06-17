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

@SuppressWarnings("all") public class deprecated_1_0 extends Strategy 
{ 
  public static deprecated_1_0 instance = new deprecated_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy v_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("deprecated_1_0");
    Fail1370:
    { 
      IStrategoTerm w_32979 = null;
      IStrategoTerm v_32979 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consdeprecated_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1370;
      v_32979 = term.getSubterm(0);
      IStrategoList annos131 = term.getAnnotations();
      w_32979 = annos131;
      term = v_32795.invoke(context, v_32979);
      if(term == null)
        break Fail1370;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consdeprecated_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, w_32979));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}