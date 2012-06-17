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

@SuppressWarnings("all") public class $Import$Renamed_2_0 extends Strategy 
{ 
  public static $Import$Renamed_2_0 instance = new $Import$Renamed_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy r_32789, Strategy s_32789)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ImportRenamed_2_0");
    Fail1235:
    { 
      IStrategoTerm w_32963 = null;
      IStrategoTerm u_32963 = null;
      IStrategoTerm v_32963 = null;
      IStrategoTerm x_32963 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consImportRenamed_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1235;
      u_32963 = term.getSubterm(0);
      v_32963 = term.getSubterm(1);
      IStrategoList annos34 = term.getAnnotations();
      w_32963 = annos34;
      term = r_32789.invoke(context, u_32963);
      if(term == null)
        break Fail1235;
      x_32963 = term;
      term = s_32789.invoke(context, v_32963);
      if(term == null)
        break Fail1235;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consImportRenamed_2, new IStrategoTerm[]{x_32963, term}), checkListAnnos(termFactory, w_32963));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}