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

@SuppressWarnings("all") public class $Desugared_1_0 extends Strategy 
{ 
  public static $Desugared_1_0 instance = new $Desugared_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_9751)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Desugared_1_0");
    Fail408:
    { 
      IStrategoTerm j_9925 = null;
      IStrategoTerm i_9925 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
        break Fail408;
      i_9925 = term.getSubterm(0);
      IStrategoList annos15 = term.getAnnotations();
      j_9925 = annos15;
      term = h_9751.invoke(context, i_9925);
      if(term == null)
        break Fail408;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, j_9925));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}