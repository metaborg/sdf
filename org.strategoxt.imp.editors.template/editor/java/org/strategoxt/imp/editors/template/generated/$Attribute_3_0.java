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

@SuppressWarnings("all") public class $Attribute_3_0 extends Strategy 
{ 
  public static $Attribute_3_0 instance = new $Attribute_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy x_9751, Strategy y_9751, Strategy z_9751)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Attribute_3_0");
    Fail450:
    { 
      IStrategoTerm b_9927 = null;
      IStrategoTerm y_9926 = null;
      IStrategoTerm z_9926 = null;
      IStrategoTerm a_9927 = null;
      IStrategoTerm c_9927 = null;
      IStrategoTerm d_9927 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consAttribute_3 != ((IStrategoAppl)term).getConstructor())
        break Fail450;
      y_9926 = term.getSubterm(0);
      z_9926 = term.getSubterm(1);
      a_9927 = term.getSubterm(2);
      IStrategoList annos25 = term.getAnnotations();
      b_9927 = annos25;
      term = x_9751.invoke(context, y_9926);
      if(term == null)
        break Fail450;
      c_9927 = term;
      term = y_9751.invoke(context, z_9926);
      if(term == null)
        break Fail450;
      d_9927 = term;
      term = z_9751.invoke(context, a_9927);
      if(term == null)
        break Fail450;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consAttribute_3, new IStrategoTerm[]{c_9927, d_9927, term}), checkListAnnos(termFactory, b_9927));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}