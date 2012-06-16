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

@SuppressWarnings("all") public class $Pretty$Print_1_0 extends Strategy 
{ 
  public static $Pretty$Print_1_0 instance = new $Pretty$Print_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("PrettyPrint_1_0");
    Fail492:
    { 
      IStrategoTerm n_9933 = null;
      IStrategoTerm m_9933 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPrettyPrint_1 != ((IStrategoAppl)term).getConstructor())
        break Fail492;
      m_9933 = term.getSubterm(0);
      IStrategoList annos65 = term.getAnnotations();
      n_9933 = annos65;
      term = k_9754.invoke(context, m_9933);
      if(term == null)
        break Fail492;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consPrettyPrint_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, n_9933));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}