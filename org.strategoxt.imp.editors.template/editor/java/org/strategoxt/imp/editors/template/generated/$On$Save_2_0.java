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

@SuppressWarnings("all") public class $On$Save_2_0 extends Strategy 
{ 
  public static $On$Save_2_0 instance = new $On$Save_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_32793, Strategy a_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("OnSave_2_0");
    Fail1327:
    { 
      IStrategoTerm y_32974 = null;
      IStrategoTerm w_32974 = null;
      IStrategoTerm x_32974 = null;
      IStrategoTerm z_32974 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consOnSave_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1327;
      w_32974 = term.getSubterm(0);
      x_32974 = term.getSubterm(1);
      IStrategoList annos98 = term.getAnnotations();
      y_32974 = annos98;
      term = z_32793.invoke(context, w_32974);
      if(term == null)
        break Fail1327;
      z_32974 = term;
      term = a_32794.invoke(context, x_32974);
      if(term == null)
        break Fail1327;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consOnSave_2, new IStrategoTerm[]{z_32974, term}), checkListAnnos(termFactory, y_32974));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}